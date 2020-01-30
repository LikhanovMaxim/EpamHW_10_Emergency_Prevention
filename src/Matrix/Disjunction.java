package Matrix;

final class Disjunction implements OperationMatrix {
    @Override
    public boolean calculation(boolean left, boolean right) {
        return left || right;
    }

}