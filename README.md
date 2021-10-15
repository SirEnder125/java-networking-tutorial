# NetworkingTutorial
This tutorial shows how to make a server and client and send information between the two using the Java programming language.

## What's included
Well, nothing right now besides the source code. I'll probably add a tutorial in the wiki some time.

## Source
```
io/github/sirender125
|
+---server
|     Server.java
|     ClientHandler.java
+---client
      Client.java
```

## FAQ:
**Q: I accidentally entered the wrong command on the client, and now it is not asking me for input! What happened?**<br/>
A: That is because on the server, when handling client input, the input is checked for validity, and if it is invalid,
it will not respond to it. Thus making the client on the other end wait forever. A fix for this would be to send an error
message whenever the client sends something dumb to the server.
