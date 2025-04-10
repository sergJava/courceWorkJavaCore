Условия курсовой
Вам нужно создать приложение, которое будет генерировать вопросы для экзамена.

Путь пользователя
Пользователь обращается к адресу:
/exam/get/{amount}
.
Пользователь получает список случайных вопросов и ответов. Количество вопросов равно
amount
.
Пользователь может добавлять, получать и удалять вопросы из хранилища вопросов:
/exam/java/(add/remove/find)
.
Подробное техническое задание
Создайте сущность
Question
с полями
question
и
answer
. Эта сущность будет хранить данные о вопросах.


Создайте интерфейс
QuestionService
. В нем должны быть методы работы с вопросами определенного предмета.
Реализуйте сервис
JavaQuestionService
, который будет работать с вопросами по Java. Он должен хранить список вопросов и обеспечивать работу с ним.
Реализуйте метод
getRandomQuestion
с помощью класса
Random
. Он должен возвращать случайное число от нуля до максимального.


Контроллеры
Создайте контроллер
JavaQuestionController
. Он должен позволять пользователю добавлять, просматривать и удалять вопросы по Java.

Методы контроллера:

Добавить вопрос:
/exam/java/add?question=QuestionText&answer=QuestionAnswer
.
Удалить вопрос:
/exam/java/remove?question=QuestionText&answer=QuestionAnswer
.
Получить все вопросы:
/exam/java
.


Интерфейс ExaminerService
Создайте интерфейс ExaminerService с методом
getQuestions
. Он должен возвращать список вопросов.




Реализация ExaminerServiceImpl
Реализуйте
ExaminerServiceImpl
, который будет использовать
QuestionService
.
Создайте коллекцию и заполните ее случайными вопросами с помощью
getRandomQuestion
.
Все вопросы должны быть уникальными.
Если запрошено больше вопросов, чем есть в сервисе, программа должна выбрасывать исключение со статусом
BAD_REQUEST
.


Контроллер ExamController
Создайте контроллер
ExamController
с методом
getQuestions(int amount)
.
Контроллер должен обратиться к
ExaminerService
, получить вопросы и вернуть их пользователю.
Юнит-тестирование
Покройте тестами
JavaQuestionService
и
ExaminerServiceImpl
.


Критерии оценки
Далее мы предлагаем вам решить задачи повышенной и очень высокой сложности. Однако их проверять не будут: это задания исключительно для вашей тренировки.

Повышенная сложность
Реализуйте
MathQuestionService
по аналогии с
JavaQuestionService
, но с математическими примерами.
Создайте контроллер
MathQuestionController
для работы с математическими вопросами.
Перенесите хранение вопросов в репозитории. Реализуйте интерфейс
QuestionRepository
с методами
add
,
remove
и
getAll
.
Инжектируйте репозитории в соответствующие сервисы.
Обновите
ExaminerService
для работы с вопросами из
JavaQuestionService
и
MathQuestionService
.
Обновите
JavaQuestionController
для корректной работы с интерфейсами.
Покройте тестами
MathQuestionService
и репозитории.
Очень высокая сложность
Удалите
MathQuestionRepository
. Теперь при попытках добавить, удалить или получить вопросы по математике выбрасывайте исключение со статусом
405 Method Not Allowed
.
Добавьте генерацию вопросов по математике в метод
getRandomQuestion
сервиса
MathQuestionService
.
Удалите поля для каждого сервиса вопросов в
ExaminerServiceImpl
. Соберите их в коллекцию и переработайте способ сборки вопросов.