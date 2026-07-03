class Solution {
    public String simplifyPath(String path) {

        StringBuilder sb = new StringBuilder();

        String[] parts = path.split("/");

        for (String part : parts) {

            if (part.equals("") || part.equals(".")) {
                continue;
            }

            if (part.equals("..")) {

                if (sb.length() == 0) {
                    continue;
                }

                int lastSlash = sb.lastIndexOf("/");

                if (lastSlash != -1) {
                    sb.delete(lastSlash, sb.length());
                }

            } else {
                sb.append("/").append(part);
            }
        }

        if (sb.length() == 0) {
            return "/";
        }

        return sb.toString();
    }
}