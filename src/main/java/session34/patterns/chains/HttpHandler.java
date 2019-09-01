package session34.patterns.chains;

interface Request{
}
interface Response{
}

interface HttpHandler {
    void handle(Request request, Response response);
}

class HttpHandler1 implements HttpHandler {
    private final HttpHandler next;

    HttpHandler1(HttpHandler next) {
        this.next = next;
    }

    @Override
    public void handle(Request request, Response response) {
        // handle what I can
        next.handle(request, response);
    }
}
