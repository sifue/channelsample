package channelsample.controller;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import channelsample.service.Channel;

public class IndexController extends Controller {

    private Channel channel = new Channel();
    
    @Override
    public Navigation run() throws Exception {
       
        String channelId = "testchannel"; 
        String channelToken = channel.getChannel(channelId); 
        
        requestScope("channelToken", channelToken);
        
        return forward("index.jsp");
    }
}
