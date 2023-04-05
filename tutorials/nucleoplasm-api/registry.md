[简体中文](cn/registry.md)

# registry (item,block,...)

## using DeferredRegister class
    DeferredRegister<Item> itemNRegistry = DeferredRegister.create(NucleoplasmNuclide.MOD_ID, Registry.ITEM_REGISTRY);

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

        public static void init(DeferredRegister<Item> registry) {
            for (ExampleRegItem value : values()) {
                value.supplier = registry.register(value.id, value.item);
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
	
## such as
nucleoplasm nuclide mod -> RegItem.class