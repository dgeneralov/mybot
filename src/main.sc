require: slotfilling/slotFilling.sc
  module = sys.zb-common

theme: /
    state: Start
        q!: *start

        # Greeting
        random:
            a: Добрый день! я помогу вам. Что Вас интересует?
            a: Здравствуйте! чем я могу Вам помочь?

        # record block
        state: record
            q: *(*записаться*/*услуг*)*
            a: куда вы хотите записаться?
            
        # information block
        state: information
            q: *(*информация*/*узнать*/*услуг*)*
            a: Какая услуга вас интересует?
            
        #clarification
        state: clarification
            q: *(*хочу уточнить*/*пропущенный*/*мне звонили*)*
            a: Вы записаны на иследование ?
            go: /Start/boolean



        # boolean
        state: boolean
            q: *(*да*)*
            a: В каком городе ?
            go: /Start/CitySelection
            q: *(*нет*)*
            go: /Start/CallAgent
            

        # service
        state: Service
            q: *(*Луч*|*кибер*|*химиотерапия*|*МРТ*|*КТ*|*офэкт*|*узи*|*анализ*|*врач*|*мнение*)*
            go: CallAgent
            
            state: Record_pet
                q: *(*пэт*)*
                a: В каком городе вы планируете проходить обследование?

        # Citis
        state: CitySelection
            q: *(*Екатеринбург*|*Курск*|*Белгород*|*Пермь*|*Москва*|*Уфа*)*
            a: Я передал ваши данные в соответствующий цент. Скоро с Вами свяжется специалист.

            state: OtherCity
                q: *(*платно*)*
                go: CallAgent

        # call agent
        state: CallAgent
            a: Соединяю с оператором

