package channelsample.service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.slim3.datastore.Datastore;
import org.slim3.datastore.EntityNotFoundRuntimeException;
import org.slim3.memcache.Memcache;

import channelsample.meta.ChannelDataMeta;
import channelsample.model.ChannelData;

import com.google.appengine.api.channel.ChannelMessage;
import com.google.appengine.api.channel.ChannelService;
import com.google.appengine.api.channel.ChannelServiceFactory;
import com.google.appengine.api.datastore.Key;


public class Channel {
    
   private static ChannelService cs = ChannelServiceFactory.getChannelService();

   public String getChannel(String channelId){
        
        Key key = Datastore.createKey(ChannelData.class, channelId);
       
        // Datastore
        ChannelData channelData = null;
        try{
            channelData = Datastore.get(ChannelDataMeta.get(), key);
        }catch (EntityNotFoundRuntimeException ignore) {}
        
        // Memcache (See channel lifecycle as memcache lifecycle, but accurately these are different.)
        ChannelData cachedChannelData = (ChannelData)Memcache.get(channelId);
        
        String channelToken = null; 
        if(channelData == null || cachedChannelData == null){
            channelToken = cs.createChannel(channelId);
            channelData = new ChannelData();
            channelData.setKey(key);
            channelData.setChannelToken(channelToken);
            Datastore.put(channelData);
            Memcache.put(channelId, channelData);
        }
        
       return channelData.getChannelToken();
   }
    
   public void sendMessage(String channelID, String content) {
       
       // URIEncode
        try {
            content = URLEncoder.encode(content, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
       
       ChannelMessage cm = 
           new ChannelMessage(channelID,
               "{ \"content\":\"" + content + "\"}");
       cs.sendMessage(cm);
   }
}
