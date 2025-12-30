
msd="$1"
if [[ -z $msd ]]; then 
    echo "please input message to commit our code 👈"
    exit 1
fi

branch=$(git branch --show-current)
if [[ $branch == "master" ]]; then
    read -p "Are you sure to push code to master 👈 (y/n): " push
    if [[ $push=="y" || $push=="Y" ]]; then
            git add .
            git commit -m "$msd"
            git push -u origin master
    else 
        exit 1
    fi
fi 

git add .
git commit -m "$msd"
git push -u origin $branch