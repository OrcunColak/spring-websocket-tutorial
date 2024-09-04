package com.colak.springwebsockettutorial.handler;

import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.util.Map;

@Component
@Slf4j
public class SocketTextHandler extends TextWebSocketHandler {

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws IOException {
        logQueryParams(session);

        String payload = message.getPayload();

        // Convert payload to Json
        JSONObject jsonObject = new JSONObject(payload);

        TextMessage textMessage = new TextMessage("Hi " + jsonObject.get("user") + " how may we help you?");
        session.sendMessage(textMessage);
    }

    // See https://msmechatronics.medium.com/websocket-wizardry-spring-webflux-edition-ca9d30346465
    private void logQueryParams(WebSocketSession session) {
        URI uri = session.getUri();
        if (uri != null) {
            UriComponentsBuilder builder = UriComponentsBuilder.fromUri(uri);

            Map<String, String> queryParams = builder.build().getQueryParams().toSingleValueMap();
            log.info("QueryParams : {}", queryParams);
        }
    }
}
