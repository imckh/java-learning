package designpattern.creational_pattern.abstract_factory_pattern.v0;

//界面皮肤工厂接口：抽象工厂
public interface SkinFactory {
    Button createButton();
    TextField createTextField();
    ComboBox createComboBox();
}
