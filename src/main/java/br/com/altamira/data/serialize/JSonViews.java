package br.com.altamira.data.serialize;

/**
 *
 * @author alessandro.holanda
 */
public class JSonViews {

    /**
     *
     */
    public static class ListView extends JSonViews { }

    /**
     *
     */
    public static class EntityView extends ListView { }
    
    /**
     *
     */
    public static class LobView extends EntityView { }
}
