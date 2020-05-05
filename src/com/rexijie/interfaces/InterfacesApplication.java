package com.rexijie.interfaces;

/**
 * Tagging interfaces are empty interfaces used to tag similar types
 */
interface TaggingInterface {}
interface Destroyable {
    default void destroy() {
        System.out.println(canDestroy());
        System.out.println("Default Destroy");
    }
    private boolean canDestroy () { // private methods can be implimented but are private
        return true;
    }
}
interface ServiceInterface extends TaggingInterface {
    String INTERFACE_CONSTANT = "INTERFACE STRING";
    static void getConstant() {
        System.out.println(INTERFACE_CONSTANT);
    }
}

interface CrudService extends ServiceInterface, Destroyable{
    void create();
    void read();
    void update();
    void delete();
}

class VideoService implements CrudService {

    @Override
    public void create() {
        System.out.println("VideoService Create");
    }

    @Override
    public void read() {
        System.out.println("VideoService Read");
    }

    @Override
    public void update() {
        System.out.println("VideoService Update");
    }

    @Override
    public void delete() {
        System.out.println("VideoService delete");
    }
}
public class InterfacesApplication {
    public static void main(String[] args) {
        CrudService videoService = new VideoService();

        videoService.create();
        videoService.read();
        videoService.update();
        videoService.delete();
        videoService.destroy();

        ServiceInterface.getConstant();
        System.out.println(videoService instanceof TaggingInterface);
    }
}
