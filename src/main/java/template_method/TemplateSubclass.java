package template_method;

public class TemplateSubclass extends Template {
    @Override
    protected void lepesElott() {
        System.out.println("Felülírtuk a lepesElott metódust");
    }

    @Override
    protected void lepesUtan() {
        System.out.println("Felülírtuk a lepesUtan metódust");
    }
}
