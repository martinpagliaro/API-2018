package modelo;

import java.util.ArrayList;

public interface ObservablePago {
	
	public ArrayList<ObserverPago> ObserverPago = null;
	public void Attach(ObserverPago o);
	public void Deattach(ObserverPago o);
	public void Notify();
	
}
