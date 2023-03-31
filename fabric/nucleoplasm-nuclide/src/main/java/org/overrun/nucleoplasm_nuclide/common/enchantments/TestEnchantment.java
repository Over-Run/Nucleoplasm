package org.overrun.nucleoplasm_nuclide.common.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;

public class TestEnchantment extends Enchantment {
    private final int maxLevel;
    public TestEnchantment(Rarity weight, EnchantmentTarget target, int maxLevel, EquipmentSlot... slotTypes) {
        super(weight, target, slotTypes);
        this.maxLevel = maxLevel;
    }

    public TestEnchantment(Rarity weight, EnchantmentTarget target, EquipmentSlot... slotTypes) {
        super(weight, target, slotTypes);
        this.maxLevel = 5;
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        user.forwardSpeed++;
        super.onTargetDamaged(user, target, level);
    }

    @Override
    public int getMaxLevel() {
        return maxLevel;
    }
}
