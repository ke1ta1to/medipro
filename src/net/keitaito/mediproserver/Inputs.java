package net.keitaito.mediproserver;

public class Inputs {

    private int id;
    private String name;
    private String world_name;
    private String input_text;

    public Inputs() {
    }

    public Inputs(int id, String name, String world_name, String input_text) {
        this.id = id;
        this.name = name;
        this.world_name = world_name;
        this.input_text = input_text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWorld_name() {
        return world_name;
    }

    public void setWorld_name(String world_name) {
        this.world_name = world_name;
    }

    public String getInput_text() {
        return input_text;
    }

    public void setInput_text(String input_text) {
        this.input_text = input_text;
    }

    @Override
    public String toString() {
        return "Inputs [id=" + id + ", name=" + name + ", world_name=" + world_name + ", input_text=" + input_text
                + "]";
    }

}
