require: slotfilling/slotFilling.sc
  module = sys.zb-common

theme: /
    state: Start
        q!: *start

        random:
            a: Добрый день! я помогу вам. Что Вас интересует?
            a: Здравствуйте! чем я могу Вам помочь?

        state: StartDialogue
            q: *(*записаться*/*услуг*)*
            a: куда вы хотите записаться?

            state: Record
                q: *(*Луч*|*кибер*|*химиотерапия*|*МРТ*|*КТ*|*офэкт*|*узи*|*анализ*|*врач*|*мнение*)*
                a: Соединяю с оператором
                
            state: Record_pet
                q: *(*пэт*)*
                a: м

                state: CitySelection
                    q: *(*Екатеринбург*|*Курск*|*Белгород*|*Пермь*|*Москва*|*Уфа*)*
                    a: Я передал ваши данные в соответствующий цент. Скоро с Вами свяжется специалист.
                    
                    state: OtherCity

                    state: OtherCity
                        q: *(*платно*)*
                        a: Соединяю с оператором


        state: CallAgent
            a: Соединяю с оператором

