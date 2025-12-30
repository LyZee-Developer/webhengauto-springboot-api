
msd="$1"
if [[ -z $msd ]]; then 
    echo "please input message to commit our code 👈"
    exit 1
fi
branch=$(git branch --show-current)
if [[ $branch != "master" ]]; then
    echo " ❌ Please checkout to master for commit our code "
    exit 1
fi 
git add .
git commit -m "$msd"
git push -u origin master