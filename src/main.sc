require: slotfilling/slotFilling.sc
  module = sys.zb-common

theme: /
    state: Start
        q!: *start

        # Greeting
        random:
            a: Добрый день! Я виртуальный помошник Пэт-технолоджи. Я могу предостаить вам информацию по услугам или помочь оформить запись. Что Вас интересует?
            a: Здравствуйте! чем я могу Вам помочь?
            

        # record block
        state: record
            q: *(*записаться*/*услуг*/*оформить запись*)*
            a: куда вы хотите записаться?
            go: /Start/clarification/information/Service
            
        #clarification
        state: clarification
            q: *(*хочу уточнить*/*пропущенный*/*мне звонили*)*
            a: Вы записаны на иследование ?
            
        # information block
            state: information
                q: *(*информация*/*узнать*/*услуг*/*предоставить информацию*)*
                a: Какая услуга вас интересует?
                go: /Start/record/information/Service
            
            
                # service
                state: Service
                    q: *(*Луч*|*кибер*|*химиотерапия*|*МРТ*|*КТ*|*офэкт*|*узи*|*анализ*|*врач*|*мнение*)*
                    go: CallAgent
                    
                # Citis
                state: CitySelection
                    q: *(*Екатеринбург*|*Курск*|*Белгород*|*Пермь*|*Москва*|*Уфа*)*
                    a: Я передал ваши данные в соответствующий цент. Скоро с Вами свяжется специалист.
            
                    state: Record_pet
                    q: *(*пэт*)*
                    a: В каком городе вы планируете проходить обследование?
            

                        state: OtherCity
                            q: *(*платно*)*
                            go: CallAgent

            # call agent
            state: CallAgent
                a: Соединяю с оператором


        state: CatchAll
            event: noMatch
            a: Простите я вас не поняла. Я могу расказать вам про услуги или помочь оформить запись.