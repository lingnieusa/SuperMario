package components;

import jade.Component;

public class SpriteRenderer extends Component {

    private boolean firstTime = false;

    @Override
    public void start() {
        System.out.println("SpriteRenderer is starting");
    }

    @Override
    public void update(float dt) {
        if (!firstTime) {
            System.out.println("I am updating");
            firstTime = true;
        }
    }
}
