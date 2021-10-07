package matrix;

import java.io.Serializable;

/**
 * Configuration for the values in a sparse matrix row.
 * This class handles packing and unpacking of values.
 * Right now it uses a simple scheme, and packs the float
 * into a short. This will work well if the floats are
 * uniformly distributed across the range in [minScore, maxScore].
 */
public class ValueConf implements Serializable {
    public static final Float MIN_SCORE = -1.1f;
    public static final Float MAX_SCORE = 1.1f;

    public final float minScore;
    public final float maxScore;
    public final float range;
    public static final int PACKED_RANGE = (Short.MAX_VALUE - Short.MIN_VALUE);

    public ValueConf() {
        this(MIN_SCORE, MAX_SCORE);
    }

    public ValueConf(float minScore, float maxScore) {
        this.minScore = minScore;
        this.maxScore = maxScore;
        range = maxScore - minScore;
    }

    public final short pack(float s) {
        float normalized = (pinchScore(s) - minScore) / range;
        return  (short)(normalized * PACKED_RANGE + Short.MIN_VALUE);
    }

    public final float unpack(short s) {
        float f = (1.0f * (s - Short.MIN_VALUE) / PACKED_RANGE) * range + minScore;
        assert(minScore <= f && f <= maxScore);
        return f;
    }

    public final float pinchScore(float s) {
        if (s > maxScore) return maxScore;
        else if (s < minScore) return minScore;
        else return s;
    }

    public boolean almostEquals(ValueConf vconf) {
        double delta = 0.001 * Math.min(range, vconf.range);   // allowed error
        return (
                (Math.abs(minScore - vconf.minScore) < delta) &&
                (Math.abs(maxScore - vconf.maxScore) < delta) &&
                (Math.abs(range - vconf.range) < delta)
            );
    }
}
