package aghenon.cooleffects.ModEntities.Custom;
import aghenon.cooleffects.ModEntities.ModEntities;
import aghenon.cooleffects.Render.PrimitiveRenderer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.world.World;

@Environment(EnvType.CLIENT)
public class CoolSplittingArrowEntity extends ThrownItemEntity {

    private int bounces = 800;


    public CoolSplittingArrowEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
        this.addVelocity(1, 5, 0);
    }

    public CoolSplittingArrowEntity(World world, LivingEntity owner) {
        super(ModEntities.COOL_SPLITTING_ARROW_ENTITY, owner, world);
    }

    public CoolSplittingArrowEntity(World world, double x, double y, double z) {
        super(ModEntities.COOL_SPLITTING_ARROW_ENTITY, x, y, z, world);
    }

    @Override
    protected Item getDefaultItem() {
        return Items.ARROW;
    }

    @Override
    public void tick() {
        super.tick();

        PrimitiveRenderer.DrawCube((float)this.getX(), (float)this.getY(), (float)this.getZ(), 0.5f, 0xF7FFFFFF);
    }

    @Override
    protected void onBlockCollision(BlockState state) {
        bounces --;
        super.onBlockCollision(state);
        if(!this.getWorld().isClient && !state.isAir()){

            this.addVelocity(1, 1, 0);

            if(bounces <= 0){
                this.getWorld().createExplosion(this, this.getX(), this.getY(), this.getZ(), 5, World.ExplosionSourceType.TNT);
                this.getWorld().sendEntityStatus(this, (byte)3);
                this.kill();
            }
        }
    }
}
