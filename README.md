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
A: On the server, nothing is sent to the client if the client sent something invalid, (a command we do not know,) so when
the client is waiting on server response, it will not get any.
