package session34.patterns.strategy;

final class CompositeDomParser implements DomParser{
    private final DomParser xmlParser;
    private final DomParser htmlParser;

    CompositeDomParser(DomParser xmlParser, DomParser htmlParser) {
        this.xmlParser = xmlParser;
        this.htmlParser = htmlParser;
    }


    @Override
    public Dom parse(String raw) {
        // resolve parser and parse
        return null;
    }
}
