/*Создайте зубчатый массив, в котором хранится температура воздуха в нашем городе на весь год. 
Массив должен содержать 12 строк, количество столбцов -количество дней в месяце.
Заполните массив случайными числами. Температура зависит от времени года.
Программа должна вывести на экран погоду на указанную дату (месяц, 
день – пользователь вводит данные с помощью клавиатуры)
в какие дни была самая теплая и самая холодная погода среднюю температуру по каждому месяцу*/

package classwork_array;

import java.util.Arrays;//Импорт класса работы с массивыами
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class ClassWork_Array {
    public static void main(String[] args) {
        Random random = new Random();
        double [][] Years = new double[12][]; //Создал масив 12 месяцев
        Scanner scanner = new Scanner(System.in);
        boolean cycle = true;
        double min = 0;
        double max = 0;
        double samm = 0;
        double average = 0;
        double maxtemp = 0;
        double mintemp = 0;
        Years[0] = new double[31];//Январь
        Years[1] = new double[28];//Февраль
        Years[2] = new double[31];//Март
        Years[3] = new double[30];//Апрель
        Years[4] = new double[31];//Май
        Years[5] = new double[30];//Июнь
        Years[6] = new double[31];//Июль
        Years[7] = new double[31];//Август
        Years[8] = new double[30];//Сентябрь
        Years[9] = new double[31];//Октябрь
        Years[10] = new double[30];//Ноябрь
        Years[11] = new double[31];//Декабрь
        //-----------------------------Январь-----------------------------------
        for(int i=0; i < Years.length; i++){
            for(int j=0; j < Years[i].length; j++){
                switch(i){
                    case 0: min = -6.0; max = -1.0; break; //Январь
                    case 1: min = -7.1; max = -1.6; break; //Февраль
                    case 2: min = -4.6; max = 2.3; break; //Март
                    case 3: min = 0.6; max = 9.2; break; //Апрель
                    case 4: min = 5.2; max = 15.3; break; //Май
                    case 5: min = 9.5; max = 19.0; break; //Июнь
                    case 6: min = 12.7; max = 22.0; break; //Июль
                    case 7: min = 12.0; max = 20.4; break; //Август
                    case 8: min = 7.6; max = 15.2; break; //Сентябрь
                    case 9: min = 3.8; max = 9.5; break; //Октябрь
                    case 10: min = -1.0; max = 3.5; break; //Ноябрь
                    case 11: min = -4.3; max = 0.4; break; //Декабрь
                }
                double randomtemp = min + (max - min) * random.nextDouble();
                Years[i][j] = randomtemp;
            }
        }
        while (cycle == true){
            //30-черный.31-красный.32-зеленый.33-желтый.34-синий.35-пурпурный.36-голубой.37-белый
            System.out.println((char) 27 + "[31m********************Программа для вывода температур в году********************");
            System.out.println((char) 27 + "[32m1.Ввести дату для получения температуры"+"\n"+(char) 27 + "[34m2.Узнать самый тёплый и самый холодный день года"+
                    "\n"+(char) 27 + "[36m3.Среднюю температуру по каждому месяцу"+"\n"+(char) 27 + "[35m0.X Выход");
            String vvod = scanner.nextLine();
            if (vvod.equals("0")){// Завершение программы
                System.out.println((char) 27 + "[31m********************Завершение программы********************");
                cycle = false;
            }else if (vvod.equals("1")){//Погода на указанный месяц день
                System.out.println((char) 27 + "[32mВведите месяц и дату для получения температуры в формате месц.дата = 1.1");
                System.out.println((char) 27 + "[32mEсли хотите вывести температуру за весь месяц введите месяц.all");
                System.out.println((char) 27 + "[32mEсли хотите вывести температуру за весь год введите all.all");
                vvod = scanner.nextLine();
                if (!vvod.equals("all.all")){
                    String MasDate[];//будущий массив символов
                    MasDate = vvod.split("\\.");//Получаем массив длинной = количесву чисел
                    if (MasDate.length == 1){
                       int vvodInt = Integer.parseInt(MasDate[0]);
                       System.out.println((char) 27 +"[32m Температура в "+vvodInt+" месяце.\n");
                       for(int i = 0; i < Years[vvodInt].length; i++){
                           System.out.printf((i+1)+" Температура = "+"%.1f",Years[vvodInt][i]);
                           System.out.println();
                       } 
                    }else if (MasDate.length >= 2){
                        int vvodInt1 = Integer.parseInt(MasDate[0]);
                        int vvodInt2 = Integer.parseInt(MasDate[1]);
                        System.out.println((char) 27 +"[32m Температура в "+vvodInt1+" месяц "+ vvodInt2 +"число: ");
                        System.out.printf((char) 27 + "[32m %.1f",Years[vvodInt1][vvodInt2]);
                        System.out.println();
                    }
                }else if (vvod.equals("all.all")){
                    for(int i = 0; i < Years.length; i++){
                        System.out.println((char) 27 +"[32mтемпература в "+(i+1)+" месяце.");
                        for(int j = 0; j < Years[i].length; j++){
                            System.out.printf(j+"."+"%.1f",Years[i][j]);
                            System.out.println();
                        }
                        System.out.println("\n\n");
                    }
                }
            }else if (vvod.equals("2")){// Самые теплый и холодный день 
                maxtemp = Years[0][0];
                mintemp = Years[0][0];
                int daymax = 0;
                int monthmax = 0;
                int daymin = 0;
                int monthin = 0;
                System.out.println((char) 27 + "[34mВведите месяц в котором вы хотите узнать самый тёплый и холодный день\n");
                System.out.println((char) 27 + "[34mВведите all если хотите узнать статистику за год");
                vvod = scanner.nextLine();
                if (!vvod.equals("all")){
                    int vvodInt = Integer.parseInt(vvod);
                    for(int i = 0; i < Years[vvodInt-1].length; i++){
                        if (maxtemp <= Years[vvodInt-1][i]){
                            maxtemp = Years[vvodInt-1][i];
                            daymax = i;
                            monthmax = vvodInt;
                        }
                        if (mintemp >= Years[vvodInt-1][i]){
                            mintemp = Years[vvodInt-1][i];
                            daymin = i;
                            monthin = vvodInt;
                        }
                    }
                    System.out.printf((char) 27 + "[34mМаксимальная температура за "+vvodInt+" месяц за "+daymax+" день = "+"%.1f",maxtemp);
                    System.out.println();
                    System.out.printf((char) 27 + "[34mМинимальная температура за "+vvodInt+" месяц  за "+daymin+" день = "+"%.1f",mintemp);
                }else if(vvod.equals("all")){
                     for(int i = 0; i < Years.length; i++){
                         for(int j = 0; j < Years[i].length; j++ ){
                            if (maxtemp <= Years[i][j]){
                                maxtemp = Years[i][j];
                                daymax = j;
                                monthmax = i;
                            }
                            if (mintemp >= Years[i][j]){
                                mintemp = Years[i][j];
                                daymin = j;
                                monthin = i;
                            }
                         }
                     }
                    System.out.printf((char) 27 + "[34mМаксимальная температура за "+monthmax+" месяц за "+daymax+" день = "+"%.1f",maxtemp);
                    System.out.println();
                    System.out.printf((char) 27 + "[34mМинимальная температура за "+monthin+" месяц  за "+daymin+" день = "+"%.1f",mintemp);
                }
            }else if (vvod.equals("3")){// Средняя температура по каждому месяцу
                average = 0;
                samm = 0;
                System.out.println((char) 27 + "[36mВведите месяц по которому вы хотите узнать среднюю температуру\n");
                System.out.println((char) 27 + "[36mВведите all если хотите узнать среднюю температуру за год");
                vvod = scanner.nextLine();
                if (!vvod.equals("all")){
                    int vvodInt = Integer.parseInt(vvod);
                    for(int i = 0; i < Years[vvodInt-1].length; i++){
                        samm += Years[vvodInt-1][i];
                    }
                    average = samm / Years[vvodInt-1].length;
                }else if (vvod.equals("all")){
                    for(int i = 0; i < Years.length; i++){
                        for(int j = 0; j < Years[i].length; j++ ){
                            samm += Years[i][j];
                        }
                        average += samm / Years[i].length;
                    }
                    average = average / 12;
                }
                System.out.printf((char) 27 + "[36mСредняя температура за "+vvod+" месяц = "+"%.1f",average);
            }else{
                System.out.println((char) 27 + "[31m********************некоректный ввод********************");
            }
            System.out.println("\n");
        }
    }
}
