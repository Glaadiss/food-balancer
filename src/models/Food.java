package models;

/**
 * Food model
 *
 * @author bartlomiejgladys
 */
public class Food {

    /**
     * Food's name like "banana", "apple"
     */
    private final String name;

    /**
     * Food's description like "Big red fruit"
     */
    private final String description;

    /**
     * Food's quality eg. 7
     */
    private final int quality;

    /**
     * Initiate Food object
     *
     * @param name Food's name
     * @param description Food's description
     * @param quality Food's quality
     */
    public Food(String name, String description, int quality) {
        this.name = name;
        this.description = description;
        this.quality = quality;
    }

    /**
     * Return the value of private field "name"
     *
     * @return food's name
     */
    public String getName() {
        return name;
    }

    /**
     * Return the value of private field "description"
     *
     * @return food's description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Return the value of private field "quality"
     *
     * @return food's quality
     */
    public int getQuality() {
        return quality;
    }

}
