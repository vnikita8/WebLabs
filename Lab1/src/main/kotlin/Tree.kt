
//Уже писал на яве, всё могу обьяснить)
class Tree(){
    var rootNode:Node?  = null

    private fun addNode( currentNode: Node? = null, value:Int = 0): Node {
        if(currentNode == null) {
            return Node(value)
        }
        when {
            value  < currentNode.value -> currentNode.left = addNode(currentNode.left,value)
            value  > currentNode.value -> currentNode.right = addNode(currentNode.right,value)
            else -> return currentNode
        }
        return currentNode
    }

    private fun deleteNode(currentNode: Node? = null, value: Int = 0): Node?{
        if(currentNode == null) {
            return null
        }
        when {
            value == currentNode.value -> {
                if(currentNode.left == null && currentNode.right == null) {
                    return null;
                }
                else if(currentNode.left != null && currentNode.right == null) {
                    return currentNode.left
                }
                else if(currentNode.left == null && currentNode.right != null) {
                    return currentNode.right
                }
                else {
                    val minVal = findMinVal(currentNode.right)
                    currentNode.value = minVal
                    currentNode.right = deleteNode(currentNode.right,minVal)
                    return currentNode
                }
            }
            value < currentNode.value -> {
                currentNode.left = deleteNode(currentNode.left,value)
                return currentNode
            }
            else -> {
                currentNode.right = deleteNode(currentNode.right,value)
                return currentNode
            }
        }
    }

    private fun findMinVal(rootNode: Node?):Int {
        if(rootNode?.left == null){
            return rootNode!!.value
        }
        else{
            findMinVal(rootNode.left)
        }
        return 0
    }

    private fun checkContains(currentNode: Node? = null, value:Int = 0): Boolean {

        if(currentNode == null) {
            return false
        }
        else if(value == currentNode.value){
            return true
        }

        return( when {
            value  < currentNode.value -> checkContains(currentNode.left,value)
            value  > currentNode.value -> checkContains(currentNode.right,value)
            else -> true } )
    }

    fun preOrderWalk(startNode: Node?) {
        val walk = mutableListOf<Int>()
        if(startNode != null) {
            walk.add(startNode.value.toInt())
            print(" $walk")
            preOrderWalk(startNode.left)
            preOrderWalk(startNode.right)
        }
    }

    fun check(value: Int = 0): Boolean {
        return checkContains(rootNode,value)
    }
    fun add(value: Int = 0) {
        rootNode = addNode(rootNode,value)
    }
    fun delete(value: Int = 0) {
        rootNode = deleteNode(rootNode,value);
    }
}

class Node(var value: Int = 0) {
    var left: Node? = null
    var right: Node? = null
}