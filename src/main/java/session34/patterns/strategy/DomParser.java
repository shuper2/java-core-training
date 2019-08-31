package session34.patterns.strategy;

interface DomParser {
    Dom parse(String raw);
}

class HtmlParser implements DomParser {
    @Override
    public Dom parse(String raw) {
        return null;
    }
}

class XmlParser implements DomParser {
    @Override
    public Dom parse(String raw) {
        return null;
    }
}

class Dom {

}

class DomValidationHtmlParser extends HtmlParser {
    @Override
    public Dom parse(String raw) {
        Dom dom = super.parse(raw);
        validate(dom);
        return dom;
    }

    void validate(Dom dom) throws HtmlDomValidationException{

    }
}

class HtmlDomValidationDecorator implements DomParser {
    private HtmlParser parser;

    @Override
    public Dom parse(String raw) {
        Dom dom = parser.parse(raw);
        validate(dom);
        return dom;
    }

    void validate(Dom dom) throws HtmlDomValidationException{

    }
}

class HtmlDomValidationException extends RuntimeException{}