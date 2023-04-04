[简体中文](cn/registry.md)

# registry (item,block,...)

## using NRegistry class
    NRegistry<T> tReg = new NRegistry<>(ResourceKey<Registry<T>> register);
or

    NRegistry<T> tReg = new NRegistry<>(String modid,ResourceKey<Registry<T>> register);
such as

    NRegistry<Item> items = new NRegistry<>("nucleoplasm" ,Registry.ITEM_REGISTRY);

code_example

    public static final NRegistry<Item> items = new NRegistry<>(Registry.ITEM_REGISTRY);


## using enum
    public enum ExampleRegItem {
        example_item(settings -> new ExampleItem(new Item.Properties()));
        private final Item item;
        private final String id;
        private RegistrySupplier<Item> supplier;
        ExampleRegItem(Function<Item.Properties, Item> items) {
            item = items.apply(new Item.Properties());
            id = name().toLowerCase(Locale.ROOT);
        }

        public static void init(NRegistry<Item> registry) {
            for (ExampleRegItem value : values()) {
                value.supplier = registry.add(value.id, value.item);
            }
            registry.register();
        }

        public RegistrySupplier<Item> supplier() {
            return supplier;
        }
    }

# NRegistry -> enum init -> main init
    public static void init() {
        ExampleRegItem.init(items);
    }