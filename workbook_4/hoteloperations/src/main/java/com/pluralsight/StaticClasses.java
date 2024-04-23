package com.pluralsight;

public class StaticClasses {
    // Create the variable.
    static StringBuilder sb;

    // Static method to format name without prefix, middle name, or suffix.
    public static String formatName(String lastName, String firstName) {
        return lastName + ", " + firstName;
    }

    // Static method to format name with prefix, middle name, and suffix.
    public static String formatName(String lastName, String prefix, String firstName, String middleName, String suffix) {
        // Initalize StringBuilder.
        sb = new StringBuilder();

        sb.append(lastName).append(", ");
        if (prefix != null && !prefix.isEmpty()) {
            sb.append(prefix).append(" ");
        }

        sb.append(firstName);
        if (middleName != null && !middleName.isEmpty()) {
            sb.append(" ").append(middleName);
        }

        if (suffix != null && !suffix.isEmpty()) {
            sb.append(", ").append(suffix);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        // Testing.
        System.out.println(formatName("Johnson", "Dr.", "Mel", "B", "PhD"));
        System.out.println(formatName("Johnson", "Mel", "B", null, "PhD"));
        System.out.println(formatName("Johnson", null, "Mel", null, null));
    }
}
