Здесь будет минипроект "умного" трекера задач. В отличие от большинства таск трекеров и списков дел, задача это списка -выводить не список дела, а одно единственное дело, которое сейчас предстоит сделать. Таким образом, с пользователя снимается необходимость решать, какое из кучи дел в списке задач предстоит сделать, а системой предлагается только одно дело. Задача как бы выплывает наверх из большой кучи несделанного и умоляет о том, чтобы ее наконец решили.

Выбранное дело можно либо а)выполнить, либо б)отменить, тогда оно отправляется в архив с соответствующей пометкой. Либо дело можно в)отложить, и тогда оно всплывет через какое-то кол-во итераций снова, либо г)разбить на подзадачи или добавить новые подзадачи к ужем имеющимся, которые дальше могут "выплывать" в качестве отдельных дел. После проведенных манипуляций с задачей выводится следующая, и так далее.

Основные параметры, которые будет содержать задача, и на основании которой принимается решение о том какую задачу вывести наверх, будут следующие: 1)важность задачи (чем важнее, тем чаще юудет появлятсья задача) 2)оценочная сложность задачи (стоит подумать ,как будет влиять) 3)сроки задачи, если такие есть(если они поджимают, задача вспылвает наверх чаще) 4)количество раз, которую задачу откладывали (чтобы такие задачи всплывали чаще) 5)тема/направление или цель, к которой привязана задача задачи (если какое-то направление редко выполнялось, то оно всплывает чаще, так же можно раздавать важность направлению, что будет влиять на частоту появления задачи) 6)подзадачи 7)комменатрии к задаче. Также при выпадении задачи будет доавлен элемент случайности.

Основные задачи по проекту:
0)сделать общую структуру проекта
1)Сделать первичную логику формирования списка и выбора задач
2)добавить работу с бд, хранящей задачи
3)добавить веб-интерфейс для функционала

В перспективе можно будет добавить веденеие статистики по выполненным задачам, добавить отдельных пользователей, поиграть с логикой выпадения задач, добавить возможность загружать задачи из списка или из других трекеров, сделать формирование примерного плана на следующий день или н часов, сделать обработчик "залежавшихся" задач, уведомления, визуализацию, вспомогательные материалы к задаче, и так далее. И также разные технические штуки. Добавлять таски в календарь. Добавить блокировки задач. Добавить автогенератор задач. Добавить логику чтобы отложенная задача не всплывала сразу - параметр время ожидания.
