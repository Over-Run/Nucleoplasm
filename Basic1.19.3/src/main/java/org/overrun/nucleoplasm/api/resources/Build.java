package org.overrun.nucleoplasm.api.resources;

public class Build {
    public static final Build items = new Build("/assets/nucleoplasm/items");
    private String name;
    public Build(String prefix) {
        name = prefix;
    }

    public Build copy() {
        return new Build(this.name);
    }

    public Build findName(String name) {
        this.name += "/" + name;
        return this;
    }
    public Build copyFindName(String name) {
        Build copy = copy();
        copy.findName(name);
        return copy;
    }

    public Build parentFile() {
        this.name = this.name.substring(0, this.name.lastIndexOf("/"));
        return this;
    }

    public String build(String suffix) {
        return this.name + "." + suffix;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
