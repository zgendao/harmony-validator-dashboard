#!/bin/bash
echo "                     ,
                    /|
                   /*|
                  /.+|
                 /* .|
                 |:+.:V
                 /+.:*.V
                |:.*.:+|
               /+.---.Z|
             ,(((/o^o/))V
            (())) . > ()))
            )(())(/~_))))(
           /((())())((()(/)
          /::)).&& (()))():@
         /:*::)'||.   /|+:::@
        /:::::( || V / |:/:::)
        V:::+/-'L|, &  |::*:/
         |::(|_  _'   _V+::|
         |*::V '-'   //,):/Ä
         |:::+| ||
		   " | lolcat
echo "
_______________________________________________________________________
|[] AmigaShell                                                    |F]|!\"|
|\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"|\"|
|12.Workbench:> cd harmony:one                                        | |
|12.Work:Harmony/ONE> ed run-node.asc                                 | |
|                                                                     | |
|                                                                     |_|
|_____________________________________________________________________|/|
" | lolcat
tmux new-session -d -s "nodeSession" ./run-node.sh
./boot dev
