[english](../registry.md)

# 注册 (物品,方块等)

## 使用 NRegistry 类
    DeferredRegister<Item> itemNRegistry = DeferredRegister.create(NucleoplasmNuclide.MOD_ID, Registry.ITEM_REGISTRY);


## 使用枚举
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

# NRegistry -> 枚举 init -> 主类 init
    public static void init() {
        ExampleRegItem.init(items);
    }
	
## 例如
nucleoplasm nuclide 模组的RegItem类