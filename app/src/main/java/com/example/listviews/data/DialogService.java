package com.example.listviews.data;

import java.util.List;

public class DialogService {

    public synchronized List<Dialog> getDialogs() {
        return List.of(
                new Dialog("Радостная клубника", "Подарите мне носки",
                        "https://icon-library.com/images/funny-icon/funny-icon-0.jpg"),
                new Dialog("Морж", "Относительность времени позволяет добиться квантового консенсуса.",
                        "https://icon-library.com/images/funny-icon/funny-icon-3.jpg"),
                new Dialog("Облепиховый взвар", "Ягодка-малинка",
                        "https://icon-library.com/images/funny-icon/funny-icon-7.jpg"),
                new Dialog("Добрыня", "Я выступаю за все самое лучшее",
                        "https://icon-library.com/images/funny-icon/funny-icon-8.jpg"),
                new Dialog("Крекер", "Для молока или соли подхожу я",
                        "https://icon-library.com/images/funny-icon/funny-icon-9.jpg"),
                new Dialog("Лолушка", "а где лулзы??))))",
                        "https://icon-library.com/images/funny-icon/funny-icon-10.jpg"),
                new Dialog("Кисель", "Ко мне невозможно относиться равнодушно",
                        "https://icon-library.com/images/funny-icon/funny-icon-11.jpg")

        );
    }

}
