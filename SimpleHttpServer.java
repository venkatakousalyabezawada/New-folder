import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleHttpServer {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server is running at http://localhost:8080");

        while (true) {
            Socket client = server.accept();
            OutputStream out = client.getOutputStream();

            String response = """
                HTTP/1.1 200 OK
                Content-Type: text/html

                <!DOCTYPE html>
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>My Java Website</title>
                    <style>
                        body {
                            font-family: Arial, sans-serif;
                            margin: 0;
                            padding: 0;
                            background-color: #f4f4f4;
                            text-align: center;
                        }
                        h1 { color: #333; }
                    </style>
                </head>
                <body>
                    <h1>Welcome to My Java Web Application!</h1>
                    <p>This is served by a custom HTTP server written in Java.</p>
                </body>
                </html>
            """;

            out.write(response.getBytes());
            out.flush();
            client.close();
        }
    }
}
