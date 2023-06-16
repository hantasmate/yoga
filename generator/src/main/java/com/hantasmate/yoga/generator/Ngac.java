/*
 * copyright(c) 2018-2023 tabuyos all right reserved.
 */
package com.hantasmate.yoga.generator;

import gov.nist.csd.pm.exceptions.PMException;
import gov.nist.csd.pm.pdp.decider.Decider;
import gov.nist.csd.pm.pdp.decider.PReviewDecider;
import gov.nist.csd.pm.pip.graph.Graph;
import gov.nist.csd.pm.pip.graph.GraphSerializer;
import gov.nist.csd.pm.pip.graph.MemGraph;
import gov.nist.csd.pm.pip.graph.model.nodes.Node;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static gov.nist.csd.pm.pip.graph.model.nodes.NodeType.O;
import static gov.nist.csd.pm.pip.graph.model.nodes.NodeType.OA;
import static gov.nist.csd.pm.pip.graph.model.nodes.NodeType.PC;
import static gov.nist.csd.pm.pip.graph.model.nodes.NodeType.U;
import static gov.nist.csd.pm.pip.graph.model.nodes.NodeType.UA;

/**
 * Ngac
 *
 * @author tabuyos
 * @since 2023/3/21
 */
@SuppressWarnings("AlibabaLowerCamelCaseVariableNaming")
public class Ngac {

  public static void main(String[] args) throws PMException {
    Random rand = new Random();

    // 1. Create a new Graph instance.  For this example, we'll use the `MemGraph` which is an in
    // memory implementation of the Graph interface.
    Graph graph = new MemGraph();

    // 2. Create the user nodes `u1` and `u2`.
    long user1ID = graph.createNode(rand.nextLong(), "u1", U, null).getID();
    long user2ID = graph.createNode(rand.nextLong(), "u2", U, null).getID();

    // 3. Create the object, `o1` that will be the target of the access queries.
    long objectID = graph.createNode(rand.nextLong(), "o1", O, null).getID();

    // 4. Create the `RBAC` policy class node.
    long rbacID = graph.createNode(rand.nextLong(), "RBAC", PC, null).getID();

    // 5. Create an object attribute for the `Accounts`.
    long accountsID = graph.createNode(rand.nextLong(), "Accounts", OA, null).getID();

    // 6. Create the `Teller` and `Auditor` user attributes.
    long tellerID = graph.createNode(rand.nextLong(), "Teller", UA, null).getID();
    long auditorID = graph.createNode(rand.nextLong(), "Auditor", UA, null).getID();

    // 7. Assign the `Accounts` object attribute to the `RBAC` policy class node.
    graph.assign(accountsID, rbacID);

    // 8. Assign the object, `o1`, to the `Accounts` object attribute.
    graph.assign(objectID, accountsID);

    // 9. Assign `u1` to the `Teller` user attribute and `u2` to the `Auditor` user attribute.
    graph.assign(user1ID, tellerID);
    graph.assign(user2ID, auditorID);

    // 10. Create the associations for `Teller` and `Auditor` on `Account` in RBAC. `Teller` has
    // read and write permissions, while `Auditor` just has read permissions.
    graph.associate(tellerID, accountsID, new HashSet<>(Arrays.asList("r", "w")));
    graph.associate(auditorID, accountsID, new HashSet<>(Arrays.asList("r", "x")));

    // 11. Create the `Branches` policy class.
    long branchesID = graph.createNode(rand.nextLong(), "branches", PC, null).getID();

    // 12. Create an object attribute for `Branch 1`.
    long branch1OAID = graph.createNode(rand.nextLong(), "branch 1", OA, null).getID();

    // 13. Assign the branch 1 OA to the branches PC
    graph.assign(branch1OAID, branchesID);

    // 14. Create the `Branch 1` user attribute
    long branches1UAID = graph.createNode(rand.nextLong(), "branch 1", UA, null).getID();

    // 15. Assign the object, `o1`, to the `Branch 1` object attribute
    graph.assign(objectID, branch1OAID);

    // 16. Assign the users, `u1` and `u2`, to the branch 1 user attribute
    graph.assign(user1ID, branches1UAID);
    graph.assign(user2ID, branches1UAID);

    // 17. Create an association between the `branch 1` user attribute and the `branch 1` object
    // attribute.
    // This will give both users read and write on `o1` under the `branches` policy class.
    graph.associate(branches1UAID, branch1OAID, new HashSet<>(Arrays.asList("r", "w", "x")));

    // 18. Test the configuration using the `PReviewDecider` implementation of the `Decider`
    // interface.
    // The constructor for a `PReviewDecider` receives the graph we created and a list of
    // prohibitions.
    // Since no prohibitions are used in this example, we'll pass null.
    Decider decider = new PReviewDecider(graph, null);
    System.out.println(graph.getNodes());

    // 19. Check that `u1` has read and write permissions on `o1`.
    Set<String> permissions = decider.list(user1ID, 0, objectID);
    System.out.println(permissions);
    System.out.println(decider.getAccessibleNodes(user1ID, 0));
    System.out.println(decider.getAccessibleNodes(user2ID, 0));
    System.out.println(decider.list(user2ID, 0, branch1OAID));

    // 20. Check that `u1` has read permissions on `o1`.
    permissions = decider.list(user2ID, 0, objectID);
    System.out.println(permissions);

    // System.out.println(GraphSerializer.toJson(graph));
  }
}
