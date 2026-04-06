<div align="center">

<img src="https://capsule-render.vercel.app/api?type=waving&color=gradient&customColorList=6,11,20&height=160&section=header&text=Acyclic%20Graph%20Checker&fontSize=42&fontColor=fff&fontAlignY=38&desc=Algorithms%3A%20Theory%2C%20Design%2C%20and%20Implementation&descSize=16&descAlignY=62&descColor=d4b8ff" width="100%" />

<br/>


</div>

## About:

A Java program that determines whether a directed graph is **acyclic or cyclic** using the **Sink Elimination** algorithm. When a cycle is detected, the exact cycle path is reconstructed using **Depth-First Search (DFS)**.

- **Adjacency List** : the graph is stored as an array of lists where each node only holds its outgoing neighbors, making it far more memory-efficient than a matrix for large sparse graphs
- **Sink Elimination** : repeatedly finds and removes nodes with no outgoing edges (sinks); if the graph empties completely it's acyclic, if it gets stuck before emptying a cycle exists 
- **DFS Cycle Finder** : once a cycle is confirmed, traces the exact loop path by tracking visited nodes and following parent pointers back to the repeated node


## Tech Stack:

<div align="center">

<table>
  <tr>
    <td align="center" width="110">
      <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg" width="48" height="48"/>
      <br/><sub><b>Java</b></sub>
    </td>
    <td align="center" width="110">
      <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/intellij/intellij-original.svg" width="48" height="48"/>
      <br/><sub><b>IntelliJ IDEA</b></sub>
    </td>
    <td align="center" width="110">
      <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/git/git-original.svg" width="48" height="48"/>
      <br/><sub><b>Git</b></sub>
    </td>
    <td align="center" width="110">
      <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/github/github-original.svg" width="48" height="48"/>
      <br/><sub><b>GitHub</b></sub>
    </td>
  </tr>
</table>

</div>


<div align="center">
<img src="https://capsule-render.vercel.app/api?type=waving&color=gradient&customColorList=6,11,20&height=80&section=footer" width="100%" />
</div>
