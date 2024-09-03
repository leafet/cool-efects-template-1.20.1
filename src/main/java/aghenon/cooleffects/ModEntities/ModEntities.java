package aghenon.cooleffects.ModEntities;
import aghenon.cooleffects.CoolEffects;
import aghenon.cooleffects.ModEntities.Custom.CoolSplittingArrowEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {

    public static final EntityType<CoolSplittingArrowEntity> COOL_SPLITTING_ARROW_ENTITY = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(CoolEffects.MOD_ID, "cool_splitting_arrow"),
            FabricEntityTypeBuilder.<CoolSplittingArrowEntity>create(SpawnGroup.MISC, CoolSplittingArrowEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25f, 0.25f))
                    .trackRangeBlocks(1).trackedUpdateRate(10)
                    .build()
    );

}
