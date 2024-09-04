# Read me

Go to
http://localhost:8080/index.html

Fill the form and send text message to websocket server

Client side is

```javascript
let socket = new WebSocket("ws://localhost:8080/ws");

socket.onmessage = function(event) {
    console.log("Received message from server:", event.data);
};

socket.onopen = function() {
    socket.send("Hello Server!");
};
```