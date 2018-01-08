package myPackage.simon;

public class MoveWei implements MoveInterfaceDaniel {
	private ButtonInterfaceDaniel b;
	public MoveWei(ButtonInterfaceDaniel buttons) {
		this.b = buttons;
	}

	@Override
	public ButtonInterfaceDaniel getButton() {
		return b;
	}

}
