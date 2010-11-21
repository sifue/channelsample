package channelsample.controller;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import channelsample.service.Channel;

public class MessageController extends Controller {

    private Channel channel = new Channel();
    
    @Override
    public Navigation run() throws Exception {
        
        String content = asString("content");
        String channelId = "testchannel"; 
        channel.sendMessage(channelId, content);
        
        response.setContentType("text/plain; charset=UTF-8");
        response.getWriter().print("post is success. content: " + content);
        response.flushBuffer();
        
        return null;
    }
}
