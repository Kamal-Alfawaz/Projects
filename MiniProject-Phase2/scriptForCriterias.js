//criteria 2

const form = document.getElementById('blogForm');
form.addEventListener('submit',add);

function add(evt){
    const blogbox = document.getElementById('noTitle');
    const blogtext = blogbox.value;
    const titlebox = document.getElementById('noDescription');
    const titletext = titlebox.value;
    if(blogtext==""){
        evt.preventDefault();
        blogbox.style.backgroundColor = 'pink';
    }
    else{
        blogbox.style.backgroundColor = 'white';
    }
    if(titletext==""){
        evt.preventDefault();
        titlebox.style.backgroundColor = 'pink';
    }
    else{
        titlebox.style.backgroundColor = 'white';
    }
}