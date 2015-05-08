whoami: give the account associated with the current login.
who: give who has logged in to the computer.
w: give who has logged in to the computer with some additional information.
ls: lists the files in the current directory.
eg: ls (options) 
options include -l: gives more information about the listed files.
      		-a: lists invisible files as well
can also search files using wild card 
ls *.doc , ls abc*.txt ...
eg: ls somedir, ls /somedir1/somedir2 (Lists files in the dir)

vi filename: editor creates a file named 'filename' and opens it up.
- press i to change the editors visual mode to write mode, wherein you can write whatever you want.
- press esc to come out of the current mode.
- press shift+ZZ or :wq to save the changes.
- Apart from arrow key you can use 
 l: move right,
 h: move right,
 k: move up,
 j: move down,
 d: page down,
 u: page up.

cat: Display complete contants of a file.
options: -b: to display with line numbers.
eg: cat -b fileName

wc: Count number of lines, words, characters in a file.
eg: wc fileName, wc fileName1 fileName2 fileName3(can also give multiple file names).

cp: copy files.
eg cp fileSource fileDest

mv: move files.
eg mv fileSource fileDest

rm: remove files
eg: rm fileName
options: -r recursively remove files, used to remove dirs
eg: rm -r dirName

cd~ : to go to home dir

cd ~otherUsersName: to go to other users homedir.

cd -: to go to last visited dir.

cd /: to go to root dir.




