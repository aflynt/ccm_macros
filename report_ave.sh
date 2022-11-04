
IMAX=8

for i in `seq $IMAX`; do
  echo ======== $i ========
  logPaths=("h_$i.csv" "T_$i.csv" "y_$i.csv")

  for fname in ${logPaths[*]}; do
    #echo --- $fname ---
    #head -n 1 $fname | sed -e "s/Monitor//g"
    tail -n 200 $fname > j.dat
    ave j.dat | grep ave:
  done
done

