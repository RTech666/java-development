package com.pluralsight;

public class NameFormatter {
    // Create the variable.
    static StringBuilder sb;

    // Static method to format name without prefix, middle name, or suffix.
    public static String format(String firstName, String lastName) {
        return lastName + ", " + firstName;
    }

    // Static method to format name with prefix, middle name, and suffix.
    public static String format(String prefix, String firstName, String middleName, String lastName, String suffix) {
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

    // Static method for full name format.
    public static String format(String fullName) {
        String[] parts = fullName.split(", ");
        if (parts.length == 1) {
            return parts[0];
        } else {
            String[] nameParts = parts[1].split(" ");
            sb = new StringBuilder();

            sb.append(parts[0]).append(", ");
            for (int i = 1; i < nameParts.length - 1; i++) {
                sb.append(nameParts[i]).append(" ");
            }

            sb.append(nameParts[nameParts.length - 1]);
            if (nameParts.length > 1) {
                sb.append(", ").append(nameParts[0]);
            }

            return sb.toString();
        }
    }

    // Tests.
    public static void main(String[] args) {
        // Testing format (firstName, lastName)
        System.out.println("Testing format (firstName, lastName):");
        System.out.println(format("John", "Doe"));

        // Testing format (prefix, firstName, middleName, lastName, suffix)
        System.out.println("\nTesting format (prefix, firstName, middleName, lastName, suffix):");
        System.out.println(format("Dr.", "John", "A", "Doe", "PhD"));

        // Testing format (fullName)
        System.out.println("\nTesting format (fullName):");
        System.out.println(format("Doe, Dr. John A, PhD"));
        System.out.println(format("Doe, John A, PhD"));
        System.out.println(format("Doe, John"));
    }
}