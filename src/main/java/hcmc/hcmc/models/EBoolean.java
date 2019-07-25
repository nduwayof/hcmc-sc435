package hcmc.hcmc.models;

/**
 * The enum E boolean.
 *
 * @author nduwayofabrice
 * @version 1.0
 */
public enum EBoolean {
    /**
     * Yes e boolean.
     */
    YES("1"),
    /**
     * No e boolean.
     */
    NO("0");

    private String description;

    EBoolean(String description){
        this.description = description;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }
}
