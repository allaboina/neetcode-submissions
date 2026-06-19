class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> unique = new HashSet<>();

        for (String e : emails) {
            String[] parts = e.split("@");
            String local = parts[0];
            String domain = parts[1];

            local = local.split("\\+")[0];
            local = local.replace(".","");
            unique.add(local + "@" + domain);
        }
        return unique.size();
    }
}