class Solution {
    private String startHostname;
    HashSet<String> visited = new HashSet<>();

    static String getHostName(String url){
        return url.split("/")[2];
    }
    void dfs(String url, HtmlParser htmlParser){
        visited.add(url);

        for(String next : htmlParser.getUrls(url)){
            if(getHostName(next).equals(startHostname) && !visited.contains(next)){
                dfs(next, htmlParser);
            }
        }
    }
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        startHostname = getHostName(startUrl);
        dfs(startUrl, htmlParser);
        return new ArrayList<>(visited);
    }
}