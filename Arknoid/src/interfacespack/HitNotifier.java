package interfacespack;

public interface HitNotifier {
    /**
     * Function Name: addHitListener.
     * Function Operation:add a interfacespack.HitListener to hit events.
     * @param hl interfacespack.HitListener
     ***/

    void addHitListener(HitListener hl);
    /**
     * Function Name: removeHitListener.
     * Function Operation: Remove hl from the list of listeners to hit events.
     * @param hl interfacespack.HitListener
     ***/
    void removeHitListener(HitListener hl);
}
