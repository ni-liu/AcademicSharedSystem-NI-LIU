window.onload = function () {
    const s = document.getElementById("pingStar"),
        m = document.getElementById('dir'),
        n = s.getElementsByTagName("li"),
        input = document.getElementById('startP'); //保存所选值
    const clearAll = function () {
        for (let i = 0; i < n.length; i++) {
            n[i].className = '';
        }
    };
    for (let i = 0; i < n.length; i++) {
        n[i].onclick = function () {
            const q = this.getAttribute("rel");
            clearAll();
            input.value = q;
            for (let i = 0; i < q; i++) {
                n[i].className = 'on';
            }
            m.innerHTML = this.getAttribute("title");
        };
        n[i].onmouseover = function () {
            const q = this.getAttribute("rel");
            clearAll();
            for (let i = 0; i < q; i++) {
                n[i].className = 'on';
            }
        };
        n[i].onmouseout = function () {
            clearAll();
            for (let i = 0; i < input.value; i++) {
                n[i].className = 'on';
            }
        }
    }
};