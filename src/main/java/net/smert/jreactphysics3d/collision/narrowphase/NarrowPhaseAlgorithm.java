package net.smert.jreactphysics3d.collision.narrowphase;

import net.smert.jreactphysics3d.collision.BroadPhasePair;
import net.smert.jreactphysics3d.collision.shapes.CollisionShape;
import net.smert.jreactphysics3d.mathematics.Transform;
import net.smert.jreactphysics3d.memory.MemoryAllocator;

/**
 * This class is an abstract class that represents an algorithm used to perform the narrow-phase of a collision
 * detection. The goal of the narrow phase algorithm is to compute contact informations of a collision between two
 * bodies.
 *
 * @author Jason Sorensen <sorensenj@smert.net>
 */
public class NarrowPhaseAlgorithm {

    /// Reference to the memory allocator
    protected MemoryAllocator mMemoryAllocator;

    /// Overlapping pair of the bodies currently tested for collision
    protected BroadPhasePair mCurrentOverlappingPair;

    /// Private copy-constructor
    protected NarrowPhaseAlgorithm(NarrowPhaseAlgorithm algorithm) {
    }

    /// Private assignment operator
    protected NarrowPhaseAlgorithm operatorEqual(NarrowPhaseAlgorithm algorithm) {
        return this;
    }

    // Constructor
    public NarrowPhaseAlgorithm(MemoryAllocator memoryAllocator) {
        mMemoryAllocator = memoryAllocator;
        mCurrentOverlappingPair = null;
    }

    // Set the current overlapping pair of bodies
    public void setCurrentOverlappingPair(BroadPhasePair overlappingPair) {
        mCurrentOverlappingPair = overlappingPair;
    }

    /// Return true and compute a contact info if the two bounding volume collide
    public abstract boolean testCollision(
            CollisionShape collisionShape1, Transform transform1,
            CollisionShape collisionShape2, Transform transform2,
            ContactPointInfo contactInfo);

}
